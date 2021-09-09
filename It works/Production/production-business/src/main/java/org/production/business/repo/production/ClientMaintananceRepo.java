/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.business.repo.production;

import org.production.business.repo.*;
import java.util.List;
import org.production.business.domain.production.ClientMaintanance;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author  Rachel Makwara
 */
public interface ClientMaintananceRepo extends AbstractRepo<ClientMaintanance, String> {

    @Override
    public List<ClientMaintanance> findAll();

    public List<ClientMaintanance> findByActiveOrderByClientMaintananceProductAsc(Boolean active);

    @Query("from ClientMaintanance e  where  e.active=:active and (e.clientMaintananceProduct Like :clientMaintananceProduct%  or e.clientMaintananceDescription Like :clientMaintananceProduct%) order by e.clientMaintananceProduct ASC")
    public List<ClientMaintanance> findByClientMaintananceProduct(@Param("clientMaintananceProduct") String clientMaintananceProduct, @Param("active") Boolean active);
}
