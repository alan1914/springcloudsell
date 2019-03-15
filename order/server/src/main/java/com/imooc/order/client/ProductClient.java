//package com.imooc.order.client;
//
//import com.imooc.order.dataobject.ProductInfo;
//import com.imooc.order.dto.CartDTO;
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//
//import java.util.List;
//
/**
 * 学习用的 feign
 * 实际用的是 在 product 中定义的 product-client
 * @author stone
 */
//@FeignClient(name = "product")
//public interface ProductClient {
//
//    @GetMapping("/msg")
//    String productMsg();
//
//    /**
//     * 获取商品列表（给订单服务用的）
//     * @param productIdList
//     * @return
//     */
//    @PostMapping("/product/listForOrder")
//    public List<ProductInfo> listForOrder(@RequestBody List<String> productIdList);
//
//    @PostMapping("/product/decreaseStock")
//    public void decreaseStock(@RequestBody List<CartDTO> cartDTOList);
//
//}
