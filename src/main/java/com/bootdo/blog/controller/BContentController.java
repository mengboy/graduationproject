package com.bootdo.blog.controller;

import java.text.SimpleDateFormat;
import java.util.*;

import org.apache.commons.io.FileUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.bootdo.blog.domain.BCommentsDO;
import com.bootdo.blog.domain.BContentDO;
import com.bootdo.blog.service.BContentService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;

/**
 * 文章内容
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2017-09-09 10:03:34
 */
@Controller
@RequestMapping("/blog/bContent")
public class BContentController {
	@Autowired
	private BContentService bContentService;

	@GetMapping()
	@RequiresPermissions("blog:bContent:bContent")
	String BContent() {
		return "blog/bContent/bContent";
	}

	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("blog:bContent:bContent")
	public PageUtils list(@RequestParam Map<String, Object> params) {
		// 查询列表数据
		Query query = new Query(params);

		List<BContentDO> bContentList = bContentService.list(query);
		int total = bContentService.count(query);

		PageUtils pageUtils = new PageUtils(bContentList, total);

		return pageUtils;
	}

	@GetMapping("/add")
	@RequiresPermissions("blog:bContent:add")
	String add() {
		return "blog/bContent/add";
	}

	@GetMapping("/test")
	@RequiresPermissions("blog:bContent:test")
	String test() {
		return "blog/bContent/test";
	}

	@GetMapping("/edit/{cid}")
	@RequiresPermissions("blog:bContent:edit")
	String edit(@PathVariable("cid") Long cid, Model model) {
		BContentDO bContentDO = bContentService.get(cid);
		model.addAttribute("bContent", bContentDO);
		return "blog/bContent/edit";
	}

	/**
	 * 保存
	 */
	@ResponseBody
	@RequiresPermissions("blog:bContent:add")
	@PostMapping("/save")
	public R save(BContentDO bContent) {
		// 处理是否允许评论等
		if (bContent.getAllowFeed() == null) {
			bContent.setAllowFeed(0);
		}

		if (bContent.getAllowFeed() == null) {
			bContent.setAllowFeed(0);
		}

		if(bContent.getPublishDate().length() == 0 || bContent.getPublishDate().equals("")){
			Date dt = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
			bContent.setPublishDate(sdf.format(dt));
		}

		int count;
		if (bContent.getCid() == null || bContent.getCid().equals("")) {
			count = bContentService.save(bContent);
		} else {
			count = bContentService.update(bContent);
		}
		if (count > 0) {
			return R.ok().put("cid", bContent.getCid());
		}
		return R.error();
	}


//	@ResponseBody
//	@RequestMapping("/upImage")
//	public Object saveImage(@RequestParam("img") MultipartFile image){
//		if(image != null){
//			Map<String, Object> map = new HashMap<>();
//			map.put("img", bContentService.saveImage(image));
//			return R.ok(map);
//		}
//		return R.error();
//	}

	@ResponseBody
	@RequestMapping(value = "/upImage")
	public Object uploadImg(@RequestParam("img") MultipartFile file){

		System.out.println();

		if(file == null){
			return R.error();
		}

		String imgUrl = null;

		imgUrl = bContentService.saveImage(file);

		Map<String, Object> map = new HashMap<>();
		map.put("url", imgUrl);

		return R.ok(map);
	}


	/**
	 * 删除
	 */
	@RequiresPermissions("blog:bContent:remove")
	@PostMapping("/remove")
	@ResponseBody
	public R remove(Long id) {
		if (bContentService.remove(id) > 0) {
			return R.ok();
		}
		return R.error();
	}

	/**
	 * 删除
	 */
	@RequiresPermissions("blog:bContent:batchRemove")
	@PostMapping("/batchRemove")
	@ResponseBody
	public R remove(@RequestParam("ids[]") Long[] cids) {
		bContentService.batchRemove(cids);
		return R.ok();
	}

	/**
	 * 获取全部文章
	 * @param params
	 * @return
	 */
	@ResponseBody
	@GetMapping("/open/list")
	public PageUtils opentList(@RequestParam Map<String, Object> params) {
		// 查询列表数据
		Query query = new Query(params);

		List<BContentDO> bContentList = bContentService.list(query);
		int total = bContentService.count(query);

		PageUtils pageUtils = new PageUtils(bContentList, total);

		return pageUtils;
	}
	
	@GetMapping("/open/post/{cid}")
	String post(@PathVariable("cid") Long cid, Model model) {
		BContentDO bContentDO = bContentService.get(cid);
		model.addAttribute("bContent", bContentDO);
		return "blog/index/post";
	}

}
