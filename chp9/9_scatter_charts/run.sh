javac -p mlib\student.processor.jar -d mods --module-source-path src $(find src -name *.java)
cp src\gui\com\packt\wickets mods\gui\com\packt\
java -p mods -m gui/com.packt.ScatterChartDemo