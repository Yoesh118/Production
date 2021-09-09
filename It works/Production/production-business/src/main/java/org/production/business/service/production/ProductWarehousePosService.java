/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose ProductWarehousePos | Templates
 * and open the template in the editor.
 */
package org.production.business.service.production;

import java.util.List;
import org.production.business.domain.production.ProductWarehouse;
import org.production.business.domain.production.ProductWarehousePos;
import org.production.business.util.dto.SearchByNameDTO;

/*
 * @author  Rachel Makwara
 */
public interface ProductWarehousePosService extends AbstractProductWarehouseAttrService<ProductWarehousePos> {

    public List<ProductWarehousePos> findByActiveOrderByProductWarehousePosNo(Boolean active);

    public List<ProductWarehousePos> search(SearchByNameDTO dto);

    public List<ProductWarehousePos> getByProductWarehouse(ProductWarehouse productWarehouse, String productWarehousePosNo);

}
