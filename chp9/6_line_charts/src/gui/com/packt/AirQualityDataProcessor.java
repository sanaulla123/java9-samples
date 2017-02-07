package com.packt;

import java.util.List;
import java.util.ArrayList;
import java.io.IOException;
import java.util.Scanner;

public class AirQualityDataProcessor{
	public List<AirQuality> loadAirQualityData() throws IOException{
		Scanner reader = new Scanner(getClass()
			.getModule()
			.getResourceAsStream("com/packt/processor/AirQualityUCI.csv")
		);

		List<AirQuality> data = new ArrayList<>();
		while(reader.hasNext()){
			String line = reader.nextLine();
			String[] elements = line.split(";");
			AirQuality aq = new AirQuality(elements);
			data.add(aq);
		}

		return data;
	}
}