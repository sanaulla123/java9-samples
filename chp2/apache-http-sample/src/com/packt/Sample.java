package com.packt;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.HttpEntity;
import org.apache.http.util.EntityUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import com.packt.model.User;
import java.net.URL;

public class Sample{
	public static void main (String [] args){
		try(CloseableHttpClient client = HttpClients.createDefault()){
			HttpGet httpGet = new HttpGet("http://jsonplaceholder.typicode.com/users");
			try(CloseableHttpResponse response = client.execute(httpGet)){
				System.out.println(response.getStatusLine());
				HttpEntity entity = response.getEntity();
				System.out.println(EntityUtils.toString(entity));

				ObjectMapper mapper = new ObjectMapper();
				List<User> users = mapper.readValue(new URL("http://jsonplaceholder.typicode.com/users"), 
					new TypeReference<List<User>>(){});

				for ( User user: users){
					System.out.println("Name: " + user.name);
				}

			}catch(Exception ex){
				ex.printStackTrace();
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}