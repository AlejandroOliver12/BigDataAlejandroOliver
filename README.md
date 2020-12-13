
# BigDataAlejandroOliver

# Unit 2

###  Instituto Tecnologico de Tijuana
### Semestre Septiembre-Enero 2020 
###  Carrera: Ingenieria en sistemas Computacionales
###  Materia: Datos Masivos
###  Maestro: Jose Christian Romero Hernandez
###   Oliver Cardenas Jesus Alejandro  16210561 



###  Index:
#### Practice1
#### Practice2
#### Practice3
#### Practice4
#### Practice5
#### Practice6
#### Practice7
#### Practice8
#### Practice9
#### Practice10
#### HomeWork
#### Test

### Practice1
####   instructions practice1
1. import the linearregression
2. use the following code to configure errors
3. start a simple spark session
4. use spark for the clean-ecommerce csv file
5. print the schema on the dataframe
6. print an example row from the dataframe
7. transform the data frame so that it takes the form of ("label", "features")
8. rename the yearly amount spent column as "label"
9. the vectorassembler object
10. use the assembler to transform our dataframe to two columns: label and features
11. create an object for line regression model
12. fit the model for the data and call this model lrmodel
13. print the coefficients and intercept for the linear regression
14. summarize the model on the training set and print the output of some metrics
15. show the residuals values, the rmse, the mse, and also the r^2

//1. Import LinearRegression
```scala   
  1. import org.apache.spark.ml.regression.LinearRegression
//2. Use the following code to configure errors   	 
  2.import org.apache.log4j._
Logger.getLogger("org").setLevel(Level.ERROR)
//Start a simple Spark Session
3.import org.apache.spark.sql.SparkSession
val spark = SparkSession.builder().getOrCreate()
//Use Spark for the Clean-Ecommerce csv file 
  4. val data  = spark.read.option("header","true").option("inferSchema", "true").format("csv").load("Clean-Ecommerce.csv")
// Print the schema on the DataFrame
5. data.printSchema
//Print an example row from the DataFrame 
6. data.head(1)
val colnames = data.columns
val firstrow = data.head(1)(0)
println("\n")
println("Example data row")
for(ind <- Range(0, colnames.length)){
   println(colnames(ind))
   println(firstrow(ind))
   println("\n")
}
//Transform the data frame so that it takes the form of ("label", "features")
7.   Import VectorAssembler and Vectors:
 
import org.apache.spark.ml.feature.VectorAssembler
import org.apache.spark.ml.linalg.Vectors
	
//Rename the Yearly Amount Spent column as "label"
8. val df = data.select(data("Yearly Amount Spent").as("label"), $"Avg Session Length", $"Time on App", $"Time on Website", $"Length of Membership", $"Yearly Amount Spent")
//The VectorAssembler Object 
9. val new_assembler = new VectorAssembler().setInputCols(Array("Avg Session Length", "Time on App", "Time on Website", "Length of Membership", "Yearly Amount Spent")).setOutputCol("features")
//Use the assembler to transform our DataFrame to two columns: label and features 	
10. val output = new_assembler.transform(df).select($"label",$"features")
//Create an object for line regression model 
11. val lr = new LinearRegression()
 //Fit the model for the data and call this model lrModel
12.val lrModel = lr.fit(output)
//Print the coefficients and intercept for the linear regression
13. println(s"Coefficients: ${lrModel.coefficients} Intercept: ${lrModel.intercept}")
//Summarize the model on the training set and print the output of some metrics
14.val trainingSummary = lrModel.summary
 
 //Show the residuals values, the RMSE, the MSE, and also the R^2
15. trainingSummary.residuals.show()
val RMSE = trainingSummary.rootMeanSquaredError
val MSE = scala.math.pow(RMSE, 2.0)
val R2 = trainingSummary.r2 
```

#####  Instructions Test
1. Load into an Iris.csv dataframe found at https://github.com/jcromerohdz/iris, prepare the necessary data to be processed by the following algorithm (Important, this cleaning must be done by means of a script from Scala in Spark)
    Use the Spark Mllib library the Machine Learning algorithm corresponding to multilayer perceptron
    2. What are the names of the columns?

    3. What is the scheme like?
    4. Print the first 5 columns.
    5. Use the describe () method to learn more about the data in the DataFrame.
    6. Make the pertinent transformation for the categorical data which will be our labels to classify.
    7. Build the classification model and explain its architecture.

    8. Print the model results
    
    ```scala
import org.apache.spark.ml.classification.MultilayerPerceptronClassifier
import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator
import org.apache.spark.ml.feature.VectorAssembler
import org.apache.spark.ml.feature.{VectorAssembler, StringIndexer}
import org.apache.spark.ml.linalg.Vectors

//1 The dataFrame is loaded from a csv
val data  = spark.read.option("header","true").option("inferSchema", "true").format("csv").load("iris.csv")


//2 Columns
data.columns



//3.The schema of the dataFrame data is printed
data.printSchema()

// null fields are removed
val dataClean = data.na.drop()


//4. We see the first 5 data and observe that the DataFrame does not have adequate headers
data.show(5)
///
//5.Describe Metod
data.describe().show()

//  A vector is generated that contains the characteristics to be evaluated
// and are saved in the features column
val vectorFeatures = (new VectorAssembler().setInputCols(Array("sepal_length","sepal_width", "petal_length","petal_width")).setOutputCol("features"))

// The features are transformed using the dataframe
val features = vectorFeatures.transform(dataClean)

// 6 Transform categorical data from species to numerical data with the label column
val speciesIndexer = new StringIndexer().setInputCol("species").setOutputCol("label")

// We adjust the indexed species with the vector features
val dataIndexed = speciesIndexer.fit(features).transform(features)

// Separate training data and testing data using indexed data
//70% de entrenamiento y 30% de prueba.
val splits = dataIndexed.randomSplit(Array(0.7, 0.3), seed = 1234L)
val train = splits(0)
val test = splits(1)

//7 Set the layer settings for the model
val layers = Array[Int](4, 5, 4, 3)

// The Multilayer algorithm trainer is configured
val trainer = new MultilayerPerceptronClassifier().setLayers(layers).setBlockSize(128).setSeed(1234L).setMaxIter(100)

// Train the model using the training data
val model = trainer.fit(train)
///
// Run the model with the test data
val result = model.transform(test)

// The prediction and the label are selected
val predictionAndLabels = result.select("prediction", "label")

// Estimate model precision
val evaluator = new MulticlassClassificationEvaluator().setMetricName("accuracy")

// 8 The result of the precision is printed
println(s"Test set accuracy = ${evaluator.evaluate(predictionAndLabels)}")
```
    
  

