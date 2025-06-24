package kr.smhrd.lunch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.smhrd.lunch.dto.GoodsDto;
import kr.smhrd.lunch.entity.Goods;
import kr.smhrd.lunch.entity.GoodsDetail;
import kr.smhrd.lunch.repository.GoodsRepository;
import kr.smhrd.lunch.service.GoodsService;

@CrossOrigin(origins="http://localhost:5173")
@RestController
@RequestMapping("/api")
public class GoodsController {
	
	@Autowired
	GoodsService goodsService;
	
	@GetMapping("/goods_list")
	public List<GoodsDto> getGoodsList() {
		// 1.
		System.out.println("[list 출력 컨트롤러]");
		
		// 2. Service -> Repository
		List<GoodsDto> goodsList = goodsService.getAllGoods();
		System.out.println(goodsList);
		return goodsList;
	}
	
	@GetMapping("/goods_list/{id}")
	public GoodsDto getGoodDetail(@PathVariable("id") int id) {
//		public List<GoodsDetail> getGoodDetail(@PathVariable("id") int id) {
		System.out.println("Detail");
		System.out.println(id);
		return goodsService.getGoodsDetail(id);
//		return goodsService.getGoodsDetail(id);
	}
	
}
