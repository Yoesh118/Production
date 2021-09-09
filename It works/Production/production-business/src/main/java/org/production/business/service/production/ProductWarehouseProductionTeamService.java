/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.business.service.production;

import java.util.List;
import org.production.business.domain.production.ProductWarehouse;
import org.production.business.domain.production.ProductWarehouseProductionTeam;
import org.production.business.util.dto.SearchByNameDTO;

/**
 * @author  Rachel Makwara
 */
public interface ProductWarehouseProductionTeamService extends AbstractProductWarehouseAttrService<ProductWarehouseProductionTeam> {

    public List<ProductWarehouseProductionTeam> findByActiveOrderByProductWarehouseProductionTeamNo(Boolean active);
    public List<ProductWarehouseProductionTeam> search(SearchByNameDTO dto);
    
     public List<ProductWarehouseProductionTeam> getByProductWarehouse(ProductWarehouse productWarehouse, String productWarehouseProductionTeamNo);
}
