package org.example;


import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;



public class Main {
    public static void main(String[] args) {

        SparkSession spark = SparkSession.builder()
                .appName("RandomSplitExample")
                .master("local[*]")
                .getOrCreate();

        Dataset<Row> data = spark.read().format("csv")
                .option("header", "true")
                .load("/Users/Admin/Downloads/archivehonda/honda_sell_data.csv");
        data.createOrReplaceTempView("honda");
        spark.sql("select * from honda ").show();
         spark.sql("select * from honda where Consumer_Rating='4.4'").show();
         spark.sql("select honda.Model, AVG(honda.Consumer_Rating)  from honda group by honda.Model ").show();
         spark.sql("select * from honda where honda.Interior_Color='Gray' order by honda.Consumer_Rating").show();
         spark.sql("select * from honda order by 5").show();
         spark.sql("select honda.Consumer_Rating, honda.Model, honda.Price from honda where honda.Model='Crosstour EX' and honda.Consumer_Rating > 4.4 group by 1,2,3 order by 1").show();
         spark.sql("select honda.Model, honda.Year, sum(honda.Comfort_Rating) from honda where honda.Model='Crosstour EX' group by 1,2").show();
         spark.sql("select * from honda where honda.Drivetrain='All-wheel Drive' order by honda.Price").show();
         spark.sql("select honda.Model, honda.Transmission from honda where honda.Mileage=5 group by 1,2").show();
         spark.sql("select honda.VIN, honda.Model from honda order by 2").show();
        // Останавливаем SparkSession
        spark.stop();



    }
}