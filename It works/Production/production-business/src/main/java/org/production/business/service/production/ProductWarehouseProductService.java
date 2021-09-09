/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose ProductWarehouseProduct | Templates
 * and open the template in the editor.
 */
package org.production.business.service.production;

import java.util.List;
import org.production.business.domain.production.ProductWarehouse;
import org.production.business.domain.production.ProductWarehouseProduct;
import org.production.business.util.dto.SearchByNameDTO;

/*
 * @author  Rachel Makwara
 */
public interface ProductWarehouseProductService extends AbstractProductWarehouseAttrService<ProductWarehouseProduct> {

    public List<ProductWarehouseProduct> findByActiveOrderByProductWarehouseProductNo(Boolean active);

    public List<ProductWarehouseProduct> search(SearchByNameDTO dto);

    public List<ProductWarehouseProduct> getByProductWarehouse(ProductWarehouse productWarehouse, String productWarehouseProductNo);

}
