package kr.smhrd.lunch.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="goods_Detail")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoodsDetail {
	
	// 연관 관계 설정이 가능하다
	// @OneToOne, @JoinColumn("goods_id")
	// Goods -> Goods_detail
	
	@Id
	private int goods_id;
	
	@Column(nullable=false)
	private String sub_thumb;
	
	@Column
	private String txt;
	
	@Column
	private String summary;
}
