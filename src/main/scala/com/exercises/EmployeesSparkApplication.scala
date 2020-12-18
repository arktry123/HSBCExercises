package com.exercises

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.lit

object EmployeesSparkApplication extends App {

  val spark = SparkSession
    .builder()
    .appName("Spark Exercise")
    .master("local[*]")
    .getOrCreate()

  val df = spark.read
    .option("header", "true")
    .option("delimiter", "|")
    .option("inferSchema", "true")
    .csv("src/main/resources/Employees.txt")

  import spark.implicits._

  df
    .select("emp_id", "emp_name", "start_date")
    .filter(lit(2020) - $"start_date" < 3)
    .collectAsList()
    .forEach(println(_))
}
