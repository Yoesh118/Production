/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.business.service.production;

import java.util.List;
import org.production.business.domain.production.ProductWarehouse;
import org.production.business.domain.production.ProductWarehouseMachinery;
import org.production.business.util.dto.SearchByNameDTO;

/**
 * @author  Rachel Makwara
 */
public interface ProductWarehouseMachineryService extends AbstractProductWarehouseAttrService<ProductWarehouseMachinery> {

    public List<ProductWarehouseMachinery> findByActiveOrderByProductWarehouseMachineryNameAsc(Boolean active);
    public List<ProductWarehouseMachinery> search(SearchByNameDTO dto);
    
      public List<ProductWarehouseMachinery> getByProductWarehouse(ProductWarehouse productWarehouse, String productWarehouseMachineryNo);
}
