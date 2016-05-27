/**************************************************************************
 * TypesTestWSBase.java, pokemon Android
 *
 * Copyright 2016
 * Description : 
 * Author(s)   : Harmony
 * Licence     : 
 * Last update : May 27, 2016
 *
 **************************************************************************/
package com.kerhomjarnoin.pokemon.test.base;

import java.util.ArrayList;

import android.database.Cursor;

import com.kerhomjarnoin.pokemon.data.TypesWebServiceClientAdapter;
import com.kerhomjarnoin.pokemon.data.RestClient.RequestConstants;
import com.kerhomjarnoin.pokemon.entity.Types;
import com.kerhomjarnoin.pokemon.fixture.TypesDataLoader;
import com.kerhomjarnoin.pokemon.test.utils.TypesUtils;
import com.kerhomjarnoin.pokemon.test.utils.TestUtils;

import com.google.mockwebserver.MockResponse;

import junit.framework.Assert;

/** Types Web Service Test.
 * 
 * @see android.app.Fragment
 */
public abstract class TypesTestWSBase extends TestWSBase {
    /** model {@link Types}. */
    protected Types model;
    /** web {@link TypesWebServiceClientAdapter}. */
    protected TypesWebServiceClientAdapter web;
    /** entities ArrayList<Types>. */
    protected ArrayList<Types> entities;
    /** nbEntities Number of entities. */
    protected int nbEntities = 0;

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        String host = this.server.getHostName();
        int port = this.server.getPort();

        this.web = new TypesWebServiceClientAdapter(
                this.ctx, host, port, RequestConstants.HTTP);
        
        this.entities = new ArrayList<Types>();        
        this.entities.addAll(TypesDataLoader.getInstance(this.ctx).getMap().values());
        
        if (entities.size() > 0) {
            this.model = this.entities.get(TestUtils.generateRandomInt(0,entities.size()-1));
        }

        this.nbEntities += TypesDataLoader.getInstance(this.ctx).getMap().size();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
    
    /** Test case Create Entity */
    public void testInsert() {
        this.server.enqueue(new MockResponse().setBody("{'result'='0'}"));

        int result = this.web.insert(this.model);

        Assert.assertTrue(result >= 0);
    }
    
    /** Test case Get Entity. */
    public void testGet() {
        this.server.enqueue(new MockResponse().setBody(
                this.web.itemToJson(this.model).toString()));

        int result = this.web.get(this.model);

        Assert.assertTrue(result >= 0);
    }

    /** Test case Read Entity. */
    public void testQuery() {
        this.server.enqueue(new MockResponse().setBody(
                this.web.itemToJson(this.model).toString()));

        Cursor result = this.web.query(this.model.getId());
        
        Assert.assertTrue(result.getCount() >= 0);
    }

    /** Test case get all Entity. */
    public void testGetAll() {
        this.server.enqueue(new MockResponse().setBody("{Typess :"
            + this.web.itemsToJson(this.entities).toString() + "}"));

        ArrayList<Types> typesList = 
                new ArrayList<Types>();

        int result = this.web.getAll(typesList);

        Assert.assertEquals(typesList.size(), this.entities.size());
    }
    
    /** Test case Update Entity. */
    public void testUpdate() {
        this.server.enqueue(new MockResponse().setBody("{'result'='1'}"));

        int result = this.web.update(this.model);

        Assert.assertTrue(result >= 0);
        
        this.server.enqueue(new MockResponse().setBody(
                this.web.itemToJson(this.model).toString()));

        Types item = new Types();
        item.setId(this.model.getId());

        result = this.web.get(item);
        
        TypesUtils.equals(this.model, item);
    }
    
    /** Test case Delete Entity. */
    public void testDelete() {
        this.server.enqueue(new MockResponse().setBody("{'result'='1'}"));

        int result = this.web.delete(this.model);

        Assert.assertTrue(result == 0);

        this.server.enqueue(new MockResponse().setBody("{}"));

        result = this.web.get(this.model);

        Assert.assertTrue(result < 0);
    }
}
