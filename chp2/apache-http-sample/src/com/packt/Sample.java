package com.packt;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.HttpEntity;
import org.apache.http.util.EntityUtils;

public class Sample{
	public static void main (String [] args){
		try(CloseableHttpClient client = HttpClients.createDefault()){
			HttpGet httpGet = new HttpGet("http://jsonplaceholder.typicode.com/users");
			try(CloseableHttpResponse response = client.execute()){
				System.out.println(response.getStatusLine());
				HttpEntity entity = response.getEntity();
				System.out.println(EntityUtils.toString(entity));
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}