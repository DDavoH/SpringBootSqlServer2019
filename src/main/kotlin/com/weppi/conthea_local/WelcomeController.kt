package com.weppi.conthea_local


import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import java.sql.*


@RestController
class WelcomeController() {


    @GetMapping("/texto")
    fun all(): String {
        return "API funcionando"
    }



    @GetMapping("/test")
    fun testing():String{


        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver")
        val connectionUrl = ""
        val con = DriverManager.getConnection(connectionUrl)

        if(con!= null ){
            println("Conexión Exitosa")
            println("=============================")
            try {
                val cStmt: CallableStatement = con.prepareCall("{Call spAfectar2('INV','475606','AFECTAR','Todo','Null','S2','9')}")
                //Enviar spAfectar;
                cStmt.execute()
                //Resultado;
                val rs: ResultSet = cStmt.resultSet
                println(rs)
            } catch (e: Exception) {
                println("Falló Conexión")
                e.printStackTrace()
            }
        }

        val e = DriverManager.getDrivers()
        while (e.hasMoreElements()) {
            println("Drivers; ")
            println(e.nextElement().javaClass.name)
        }

        return "success"
    }

}