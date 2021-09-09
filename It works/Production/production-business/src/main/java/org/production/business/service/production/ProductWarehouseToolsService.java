/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose ProductWarehouseTools | Templates
 * and open the template in the editor.
 */
package org.production.business.service.production;

import java.util.List;
import org.production.business.domain.production.ProductWarehouse;
import org.production.business.domain.production.ProductWarehouseTools;
import org.production.business.util.dto.SearchByNameDTO;

/*
 * @author  Rachel Makwara
 */
public interface ProductWarehouseToolsService extends AbstractProductWarehouseAttrService<ProductWarehouseTools> {

    public List<ProductWarehouseTools> findByActiveOrderByProductWarehouseToolNo(Boolean active);

    public List<ProductWarehouseTools> search(SearchByNameDTO dto);

    public List<ProductWarehouseTools> getByProductWarehouse(ProductWarehouse productWarehouse, String productWarehouseToolNo);

}
