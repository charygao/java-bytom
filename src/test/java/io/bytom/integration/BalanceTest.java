package io.bytom.integration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import io.bytom.api.Balance;
import io.bytom.exception.BytomException;
import io.bytom.http.Client;

public class BalanceTest {

	private static Client client;

	@Test
	public void run() {
		try {
			testListBalances();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void testListBalances() throws BytomException {
		client = TestUtils.generateClient();
		Balance.Items items = new Balance.QueryBuilder().list(client);
		assertEquals(1, items.data.size());
		assertNotNull(items.data.get(0).accountAlias);
		assertNotNull(items.data.get(0).accountId);
		assertNotNull(items.data.get(0).assetAlias);
		assertNotNull(items.data.get(0).assetId);
	}
}
