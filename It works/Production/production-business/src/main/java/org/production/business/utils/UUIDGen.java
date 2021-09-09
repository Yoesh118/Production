/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.business.utils;

import java.util.UUID;

/**
 *
 * @author  Rachel Makwara
 */
public final class UUIDGen {

    private UUIDGen() {
        throw new IllegalStateException("Class not intended to be instantiated");
    }
    
    public static final String generateUUID() {
        String id = UUID.randomUUID().toString();
        return id;
    }
}