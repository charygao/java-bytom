package com.bytom.api;

import java.util.HashMap;
import java.util.Map;
import com.bytom.exception.BytomException;
import com.bytom.http.BytomResponse;
import com.bytom.http.Client;

/**
 * 
 * @author niyuelin1990
 *
 */
public class TransactionFeed {

	/**
	 * name of the transaction feed.
	 */
	public String alias;
	/**
	 * filter, filter of the transaction feed.
	 */
	public String filter;

	/**
	 *  param, param of the transaction feed.
	 */
	public TransactionFeedParam param;

	public static class Builder {
		/**
		 * Token id
		 */
		public String alias;
		/**
		 * Token type
		 */
		public String filter;

		public Builder() {
		}

		/**
		 * 
		 * @param alias
		 *            the alias to set
		 * @return Builder
		 */
		public Builder setAlias(String alias) {
			this.alias = alias;
			return this;
		}

		/**
		 * 
		 * @param type
		 *            the type to set
		 * @return Builder
		 */
		public Builder setFilter(String filter) {
			this.filter = filter;
			return this;
		}

		/**
		 * 创建
		 * 
		 * @param client
		 * @return true or false
		 * @throws BytomException
		 *             error
		 */
		public boolean create(Client client) throws BytomException {
			return client.request("create-transaction-feed", this);
		}
	}

	/**
	 * 获取
	 * 
	 * @param client
	 * @param alias
	 * @return
	 * @throws BytomException
	 */
	public static TransactionFeed get(Client client, String alias) throws BytomException {
		Map<String, Object> req = new HashMap<String, Object>();
		req.put("alias", alias);
		return client.requestGet("get-transaction-feed", req, "txfeed", TransactionFeed.class);
	}

	/**
	 * 修改
	 * 
	 * @param client
	 * @param alias
	 * @param filter
	 * @return success return true
	 * @throws BytomException
	 */
	public static boolean update(Client client, String alias, String filter) throws BytomException {
		Map<String, Object> req = new HashMap<String, Object>();
		req.put("alias", alias);
		req.put("filter", filter);
		return client.request("update-transaction-feed", req);
	}

	/**
	 * 列表
	 * 
	 * @param client
	 * @return
	 * @throws BytomException
	 */
	public static Items list(Client client) throws BytomException {
		Items items = new Items();
		items.setClient(client);
		return items.query();
	}

	/**
	 * delete
	 * 
	 * @param client
	 * @param alias
	 * @return success return true
	 * @throws BytomException
	 */
	public static boolean delete(Client client, String alias) throws BytomException {
		Map<String, Object> req = new HashMap<String, Object>();
		req.put("alias", alias);
		return client.request("delete-transaction-feed", req);
	}

	public static class Items extends BytomResponse<TransactionFeed> {
		public Items query() throws BytomException {
			Items items = this.client.requestList("list-transaction-feeds", null, Items.class);
			return items;
		}
	}

	public class TransactionFeedParam {

		/**
		 * assetid
		 */
		public String assetid;

		/**
		 * lowerlimit
		 */
		public long lowerlimit;

		/**
		 * upperlimit
		 */
		public long upperlimit;

	}

}
