package com.bigdata.content.controller.news;

import java.text.SimpleDateFormat;
import java.util.*;

import com.bigdata.content.service.FileUploadService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.bigdata.content.domain.BContentDO;
import com.bigdata.content.service.BContentService;
import com.bigdata.common.utils.PageUtils;
import com.bigdata.common.utils.Query;
import com.bigdata.common.utils.R;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文章内容
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2017-09-09 10:03:34
 */
@Controller
@RequestMapping("/content/bContent")
public class BContentController {
	@Autowired
	private BContentService bContentService;


	@Autowired
	private FileUploadService fileUploadService;

	@Value("${image.upload.dir}")
	private String imageDir;

	@GetMapping()
	@RequiresPermissions("content:bContent:bContent")
	String BContent() {
		return "content/news/bContent";
	}

	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("content:bContent:bContent")
	public PageUtils list(@RequestParam Map<String, Object> params) {
		// 查询列表数据
		Query query = new Query(params);

		List<BContentDO> bContentList = bContentService.list(query);
		int total = bContentService.count(query);

		PageUtils pageUtils = new PageUtils(bContentList, total);

		return pageUtils;
	}

	@GetMapping("/add")
	@RequiresPermissions("content:bContent:add")
	String add() {
		return "content/news/add";
	}

	@GetMapping("/test")
	@RequiresPermissions("content:bContent:test")
	String test() {
		return "content/news/test";
	}

	@GetMapping("/edit/{cid}")
	@RequiresPermissions("content:bContent:edit")
	String edit(@PathVariable("cid") Long cid, Model model) {
		BContentDO bContentDO = bContentService.get(cid);
		model.addAttribute("bContent", bContentDO);
		return "content/news/edit";
	}

	/**
	 * 保存
	 */
	@ResponseBody
	@RequiresPermissions("content:bContent:add")
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



	@ResponseBody
	@RequestMapping(value = "/upImage")
	public Object uploadImg(@RequestParam("img") MultipartFile file){

		System.out.println();

		if(file == null){
			return R.error();
		}

		String imgUrl = null;

		imgUrl = fileUploadService.saveFile(file, imgUrl);

		Map<String, Object> map = new HashMap<>();
		map.put("url", imgUrl);

		return R.ok(map);
	}


	/**
	 * 删除
	 */
	@RequiresPermissions("content:bContent:remove")
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
	@RequiresPermissions("content:bContent:batchRemove")
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
