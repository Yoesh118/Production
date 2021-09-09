/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.business.repo.production;

import org.production.business.repo.*;
import java.util.List;
import org.production.business.domain.production.ProductRequirements;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author  Rachel Makwara
 */
public interface ProductRequirementsRepo extends AbstractRepo<ProductRequirements, String> {

    @Override
    public List<ProductRequirements> findAll();

    public List<ProductRequirements> findByActiveOrderByProductRequirementsDescriptionAsc(Boolean active);

    @Query("from ProductRequirements pr where  pr.active=:active and (pr.productRequirementsDescription Like :productRequirementsDescription% ) order by pr.productRequirementsDescription ASC")
    public List<ProductRequirements> findByProductRequirementsDescription(@Param("productRequirementsDescription") String productRequirementsDescription, @Param("active") Boolean active);
}
