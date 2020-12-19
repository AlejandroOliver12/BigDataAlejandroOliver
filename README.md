# BigDataAlejandroOliver

# Unit 2

###  Instituto Tecnologico de Tijuana
### Semestre Septiembre-Enero 2020 
###  Carrera: Ingenieria en sistemas Computacionales
###  Materia: Datos Masivos
###  Maestro: Jose Christian Romero Hernandez
###   Oliver Cardenas Jesus Alejandro  16210561 



###  Index:
###  Test

### Test3
####   instructions Test3

1. Import a simple Spark session.
2. Use lines of code to minimize errors
3. Create an instance of the Spark session
4. Import the Kmeans library for the clustering algorithm.
5. Load the Wholesale Customers Data dataset
6. Select the following columns: Fresh, Milk, Grocery, Frozen, Detergents_Paper, Delicassen and call this set feature_data
7. Import Vector Assembler and Vector
8. Create a new Vector Assembler object for the feature columns as an input set, remembering that there are no labels
9. Use the assembler object to transform feature_data
10. Create a Kmeans model with K = 3
11. Evaluate the groups using Within Set Sum of Squared Errors WSSSE and print the centroids.

```scala
//1  Import a simple Spark session.
// Import Vector Assembler and Vector
import org.apache.spark.sql.SparkSession
import org.apache.spark.ml.feature.{VectorAssembler, StringIndexer}
import org.apache.spark.ml.linalg.Vectors
import org.apache.log4j._

// 2 Use the lines of code to minimize errors

Logger.getLogger("org").setLevel(Level.ERROR)

// 3 Create an instance of the Spark session
val spark = SparkSession.builder().getOrCreate()

// 4 Import the Kmeans library for the clustering algorithm.
import org.apache.spark.ml.clustering.KMeans

// 5 We load the Wholesale Customers Data dataset
val data  = spark.read.option("header","true").option("inferSchema", "true").format("csv").load("Wholesale customers data.csv")

// The dataFrame is printed
data.printSchema()

// 6 Select the following columns: Fresh, Milk, Grocery, Frozen, Detergents_Paper, Delicassen
// and call this set feature_data

val f_data= (data.select($"Fresh", $"Milk",$"Grocery", $"Frozen", $"Detergents_Paper", $"Delicassen"))

// The dataframe is cleaned up the empty fields
val f_data_clean = f_data.na.drop()


// 8  Create a new Vector Assembler object for the feature columns
// as an input set, remembering there are no labels
val f_Data = (new VectorAssembler().setInputCols(Array("Fresh","Milk", "Grocery","Frozen", "Detergents_Paper","Delicassen")).setOutputCol("features"))

// 9 Use the assembler object to transform feature_data
val features = f_Data.transform(f_data_clean)

// 10 The Kmeans model is executed with k = 3
val kmeans = new KMeans().setK(3).setSeed(1L).setPredictionCol("cluster")
val model = kmeans.fit(features)


// 11 We evaluate the groups using Within Set Sum of Squared Errors WSSSE and
val WSSE = model.computeCost(features)
println(s"Within set sum of Squared Errors = $WSSE")

// We print the clusters
println("Cluster Centers: ")
model.clusterCenters.foreach(println)
```
