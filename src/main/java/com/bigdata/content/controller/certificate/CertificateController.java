package com.bigdata.content.controller.certificate;


import com.bigdata.common.utils.PageUtils;
import com.bigdata.common.utils.Query;
import com.bigdata.common.utils.R;
import com.bigdata.content.domain.Certificate;
import com.bigdata.content.service.CertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/content/certificate")
public class CertificateController {

    @Autowired
    CertificateService certificateService;


    @RequestMapping("")
    String certificatePage(){
        return "content/certificate/certificate";
    }


    @RequestMapping("/addCertificate")
    String addCertificate(){
        return "content/certificate/addCertificate";
    }


    @GetMapping("/editCertificate/{cid}")
    String edit(@PathVariable("cid") Integer cid, Model model) {
        Certificate solution = certificateService.selectById(cid);
        model.addAttribute("certificate", solution);
        return "content/certificate/editCertificate";
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
