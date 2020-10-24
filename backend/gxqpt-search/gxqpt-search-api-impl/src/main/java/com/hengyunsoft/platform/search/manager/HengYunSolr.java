package com.hengyunsoft.platform.search.manager;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrRequest;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.StreamingResponseCallback;
import org.apache.solr.client.solrj.beans.DocumentObjectBinder;
import org.apache.solr.client.solrj.impl.CloudSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.SolrPingResponse;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.apache.solr.common.params.SolrParams;
import org.apache.solr.common.util.NamedList;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/***
 * 包装CloudSolrClient,扩展numShards，numReplicas配置参数,所有的方法委托CloudSolrClient去执行
 */
public class HengYunSolr extends SolrClient {
    /***
     * 分布式客户端
     */
    private CloudSolrClient client;
    /***
     * 新创建集合分片数量
     */
    private int numShards;
    /***
     * 新创建集合副本数
     */
    private int numReplicas;

    public HengYunSolr(CloudSolrClient client, int numShards, int numReplicas) {
        this.client = client;
        this.numShards = numShards;
        this.numReplicas = numReplicas;
    }

    public int getNumShards() {
        return numShards;
    }

    public int getNumReplicas() {
        return numReplicas;
    }

    @Override
    public NamedList<Object> request(SolrRequest solrRequest, String s) throws SolrServerException, IOException {
        return client.request(solrRequest, s);
    }

    @Override
    public void close() throws IOException {
        client.close();
    }


    @Override
    public UpdateResponse add(String collection, Collection<SolrInputDocument> docs) throws SolrServerException, IOException {
        return client.add(collection, docs);
    }

    @Override
    public UpdateResponse add(Collection<SolrInputDocument> docs) throws SolrServerException, IOException {
        return client.add(docs);
    }

    @Override
    public UpdateResponse add(String collection, Collection<SolrInputDocument> docs, int commitWithinMs) throws SolrServerException, IOException {
        return client.add(collection, docs, commitWithinMs);
    }

    @Override
    public UpdateResponse add(Collection<SolrInputDocument> docs, int commitWithinMs) throws SolrServerException, IOException {
        return client.add(docs, commitWithinMs);
    }

    @Override
    public UpdateResponse add(String collection, SolrInputDocument doc) throws SolrServerException, IOException {
        return client.add(collection, doc);
    }

    @Override
    public UpdateResponse add(SolrInputDocument doc) throws SolrServerException, IOException {
        return client.add(doc);
    }

    @Override
    public UpdateResponse add(String collection, SolrInputDocument doc, int commitWithinMs) throws SolrServerException, IOException {
        return client.add(collection, doc, commitWithinMs);
    }

    @Override
    public UpdateResponse add(SolrInputDocument doc, int commitWithinMs) throws SolrServerException, IOException {
        return client.add(doc, commitWithinMs);
    }

    @Override
    public UpdateResponse add(String collection, Iterator<SolrInputDocument> docIterator) throws SolrServerException, IOException {
        return client.add(collection, docIterator);
    }

    @Override
    public UpdateResponse add(Iterator<SolrInputDocument> docIterator) throws SolrServerException, IOException {
        return client.add(docIterator);
    }

    @Override
    public UpdateResponse addBean(String collection, Object obj) throws IOException, SolrServerException {
        return client.addBean(collection, obj);
    }

    @Override
    public UpdateResponse addBean(Object obj) throws IOException, SolrServerException {
        return client.addBean(obj);
    }

    @Override
    public UpdateResponse addBean(String collection, Object obj, int commitWithinMs) throws IOException, SolrServerException {
        return client.addBean(collection, obj, commitWithinMs);
    }

    @Override
    public UpdateResponse addBean(Object obj, int commitWithinMs) throws IOException, SolrServerException {
        return client.addBean(obj, commitWithinMs);
    }

    @Override
    public UpdateResponse addBeans(String collection, Collection<?> beans) throws SolrServerException, IOException {
        return client.addBeans(collection, beans);
    }

    @Override
    public UpdateResponse addBeans(Collection<?> beans) throws SolrServerException, IOException {
        return client.addBeans(beans);
    }

    @Override
    public UpdateResponse addBeans(String collection, Collection<?> beans, int commitWithinMs) throws SolrServerException, IOException {
        return client.addBeans(collection, beans, commitWithinMs);
    }

    @Override
    public UpdateResponse addBeans(Collection<?> beans, int commitWithinMs) throws SolrServerException, IOException {
        return client.addBeans(beans, commitWithinMs);
    }

    @Override
    public UpdateResponse addBeans(String collection, Iterator<?> beanIterator) throws SolrServerException, IOException {
        return client.addBeans(collection, beanIterator);
    }

    @Override
    public UpdateResponse addBeans(Iterator<?> beanIterator) throws SolrServerException, IOException {
        return client.addBeans(beanIterator);
    }

    @Override
    public UpdateResponse commit(String collection) throws SolrServerException, IOException {
        return client.commit(collection);
    }

    @Override
    public UpdateResponse commit() throws SolrServerException, IOException {
        return client.commit();
    }

    @Override
    public UpdateResponse commit(String collection, boolean waitFlush, boolean waitSearcher) throws SolrServerException, IOException {
        return client.commit(collection, waitFlush, waitSearcher);
    }

    @Override
    public UpdateResponse commit(boolean waitFlush, boolean waitSearcher) throws SolrServerException, IOException {
        return client.commit(waitFlush, waitSearcher);
    }

    @Override
    public UpdateResponse commit(String collection, boolean waitFlush, boolean waitSearcher, boolean softCommit) throws SolrServerException, IOException {
        return client.commit(collection, waitFlush, waitSearcher, softCommit);
    }

    @Override
    public UpdateResponse commit(boolean waitFlush, boolean waitSearcher, boolean softCommit) throws SolrServerException, IOException {
        return client.commit(waitFlush, waitSearcher, softCommit);
    }

    @Override
    public UpdateResponse optimize(String collection) throws SolrServerException, IOException {
        return client.optimize(collection);
    }

    @Override
    public UpdateResponse optimize() throws SolrServerException, IOException {
        return client.optimize();
    }

    @Override
    public UpdateResponse optimize(String collection, boolean waitFlush, boolean waitSearcher) throws SolrServerException, IOException {
        return client.optimize(collection, waitFlush, waitSearcher);
    }

    @Override
    public UpdateResponse optimize(boolean waitFlush, boolean waitSearcher) throws SolrServerException, IOException {
        return client.optimize(waitFlush, waitSearcher);
    }

    @Override
    public UpdateResponse optimize(String collection, boolean waitFlush, boolean waitSearcher, int maxSegments) throws SolrServerException, IOException {
        return client.optimize(collection, waitFlush, waitSearcher, maxSegments);
    }

    @Override
    public UpdateResponse optimize(boolean waitFlush, boolean waitSearcher, int maxSegments) throws SolrServerException, IOException {
        return client.optimize(waitFlush, waitSearcher, maxSegments);
    }

    @Override
    public UpdateResponse rollback(String collection) throws SolrServerException, IOException {
        return client.rollback(collection);
    }

    @Override
    public UpdateResponse rollback() throws SolrServerException, IOException {
        return client.rollback();
    }

    @Override
    public UpdateResponse deleteById(String collection, String id) throws SolrServerException, IOException {
        return client.deleteById(collection, id);
    }

    @Override
    public UpdateResponse deleteById(String id) throws SolrServerException, IOException {
        return client.deleteById(id);
    }

    @Override
    public UpdateResponse deleteById(String collection, String id, int commitWithinMs) throws SolrServerException, IOException {
        return client.deleteById(collection, id, commitWithinMs);
    }

    @Override
    public UpdateResponse deleteById(String id, int commitWithinMs) throws SolrServerException, IOException {
        return client.deleteById(id, commitWithinMs);
    }

    @Override
    public UpdateResponse deleteById(String collection, List<String> ids) throws SolrServerException, IOException {
        return client.deleteById(collection, ids);
    }

    @Override
    public UpdateResponse deleteById(List<String> ids) throws SolrServerException, IOException {
        return client.deleteById(ids);
    }

    @Override
    public UpdateResponse deleteById(String collection, List<String> ids, int commitWithinMs) throws SolrServerException, IOException {
        return client.deleteById(collection, ids, commitWithinMs);
    }

    @Override
    public UpdateResponse deleteById(List<String> ids, int commitWithinMs) throws SolrServerException, IOException {
        return client.deleteById(ids, commitWithinMs);
    }

    @Override
    public UpdateResponse deleteByQuery(String collection, String query) throws SolrServerException, IOException {
        return client.deleteByQuery(collection, query);
    }

    @Override
    public UpdateResponse deleteByQuery(String query) throws SolrServerException, IOException {
        return client.deleteByQuery(query);
    }

    @Override
    public UpdateResponse deleteByQuery(String collection, String query, int commitWithinMs) throws SolrServerException, IOException {
        return client.deleteByQuery(collection, query, commitWithinMs);
    }

    @Override
    public UpdateResponse deleteByQuery(String query, int commitWithinMs) throws SolrServerException, IOException {
        return client.deleteByQuery(query, commitWithinMs);
    }

    @Override
    public SolrPingResponse ping() throws SolrServerException, IOException {
        return client.ping();
    }

    @Override
    public QueryResponse query(String collection, SolrParams params) throws SolrServerException, IOException {
        return client.query(collection, params);
    }

    @Override
    public QueryResponse query(SolrParams params) throws SolrServerException, IOException {
        return client.query(params);
    }

    @Override
    public QueryResponse query(String collection, SolrParams params, SolrRequest.METHOD method) throws SolrServerException, IOException {
        return client.query(collection, params, method);
    }

    @Override
    public QueryResponse query(SolrParams params, SolrRequest.METHOD method) throws SolrServerException, IOException {
        return client.query(params, method);
    }

    @Override
    public QueryResponse queryAndStreamResponse(String collection, SolrParams params, StreamingResponseCallback callback) throws SolrServerException, IOException {
        return client.queryAndStreamResponse(collection, params, callback);
    }

    @Override
    public QueryResponse queryAndStreamResponse(SolrParams params, StreamingResponseCallback callback) throws SolrServerException, IOException {
        return client.queryAndStreamResponse(params, callback);
    }

    @Override
    public SolrDocument getById(String collection, String id) throws SolrServerException, IOException {
        return client.getById(collection, id);
    }

    @Override
    public SolrDocument getById(String id) throws SolrServerException, IOException {
        return client.getById(id);
    }

    @Override
    public SolrDocument getById(String collection, String id, SolrParams params) throws SolrServerException, IOException {
        return client.getById(collection, id, params);
    }

    @Override
    public SolrDocument getById(String id, SolrParams params) throws SolrServerException, IOException {
        return client.getById(id, params);
    }

    @Override
    public SolrDocumentList getById(String collection, Collection<String> ids) throws SolrServerException, IOException {
        return client.getById(collection, ids);
    }

    @Override
    public SolrDocumentList getById(Collection<String> ids) throws SolrServerException, IOException {
        return client.getById(ids);
    }

    @Override
    public SolrDocumentList getById(String collection, Collection<String> ids, SolrParams params) throws SolrServerException, IOException {
        return client.getById(collection, ids, params);
    }

    @Override
    public SolrDocumentList getById(Collection<String> ids, SolrParams params) throws SolrServerException, IOException {
        return client.getById(ids, params);
    }

    @Override
    public DocumentObjectBinder getBinder() {
        return client.getBinder();
    }


    @Override
    public int hashCode() {
        return client.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return client.equals(obj);
    }

    @Override
    public String toString() {
        return client.toString();
    }
}
