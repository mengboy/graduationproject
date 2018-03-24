package com.bootdo.type.controller.certificate;


import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;
import com.bootdo.type.domain.Certificate;
import com.bootdo.type.service.CertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/type/certificate")
public class CertificateController {

    @Autowired
    CertificateService certificateService;


    @RequestMapping("")
    String certificatePage(){
        return "type/certificate/certificate";
    }


    @RequestMapping("/addCertificate")
    String addCertificate(){
        return "type/certificate/addCertificate";
    }


    @GetMapping("/editCertificate/{cid}")
    String edit(@PathVariable("cid") Integer cid, Model model) {
        Certificate solution = certificateService.selectById(cid);
        model.addAttribute("certificate", solution);
        return "type/certificate/editCertificate";
    }

    @RequestMapping("/save")
    @ResponseBody
    Object save(Certificate certificate){
        try{
            if(certificate.getCid() == null){
                certificate.setIsDel("0");
                certificateService.insert(certificate);
            }else {
                certificateService.update(certificate);
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error();
        }
        return R.ok();
    }


    @RequestMapping("/del")
    @ResponseBody
    Object del(@RequestParam  Integer id){
        try{
            certificateService.upDelStatus(id);
        }catch (Exception e){
            e.printStackTrace();
            return R.error();
        }
        return R.ok();
    }




    @RequestMapping("/selectById")
    @ResponseBody
    Object selectById(@RequestParam  Integer id){
        Certificate certificate = null;

        try{
            certificate = certificateService.selectById(id);
        }catch (Exception e){
            e.printStackTrace();
            return R.error();
        }
        return R.ok("certificate", certificate);
    }

    @RequestMapping("/selectPages")
    @ResponseBody
    Object selectPages(@RequestParam Map<String, Object> params){
        Query query = new Query(params);
        List<Certificate> certificateList = null;
        try{
            certificateList = certificateService.list(query);
            int i = 1;
            for(Certificate certificate : certificateList){
                certificate.setSn(i);
                i++;
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error();
        }
        int total = certificateService.count();


        return new PageUtils(certificateList, total);
    }

}
