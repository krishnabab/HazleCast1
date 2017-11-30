<?xml version="1.0" ?>

<TestCase name="HelloTest" version="5">

<meta>
   <create version="9.5.1" buildNumber="9.5.1.6" author="admin" date="01/26/2017" host="SALMA22" />
   <lastEdited version="9.5.1" buildNumber="9.5.1.6" author="admin" date="01/26/2017" host="SALMA22" />
</meta>

<id>B1DF7657E3FA11E6B557B4AC20524153</id>
<Documentation>Put documentation of the Test Case here.</Documentation>
<IsInProject>true</IsInProject>
<sig>ZWQ9NSZ0Y3Y9NSZsaXNhdj05LjUuMSAoOS41LjEuNikmbm9kZXM9LTExNjQzOTMyNjk=</sig>
<subprocess>false</subprocess>

<initState>
</initState>

<resultState>
</resultState>

<deletedProps>
</deletedProps>

    <Node name="REST-Call" log=""
          type="com.itko.lisa.ws.rest.RESTNode" 
          version="3" 
          uid="B5350A0FE3FA11E6B557B4AC20524153" 
          think="500-1S" 
          useFilters="true" 
          quiet="false" 
          next="end" > 

<url>http://localhost:8010/web/service/hello</url>
<content-type></content-type>
<data-type>text</data-type>
<httpMethod>GET</httpMethod>
<onError>abort</onError>
    </Node>


    <Node name="abort" log=""
          type="com.itko.lisa.test.AbortStep" 
          version="1" 
          uid="B1DF7659E3FA11E6B557B4AC20524153" 
          think="0h" 
          useFilters="true" 
          quiet="true" 
          next="" > 

    </Node>


    <Node name="fail" log=""
          type="com.itko.lisa.test.Abend" 
          version="1" 
          uid="B1DF765BE3FA11E6B557B4AC20524153" 
          think="0h" 
          useFilters="true" 
          quiet="true" 
          next="abort" > 

    </Node>


    <Node name="end" log=""
          type="com.itko.lisa.test.NormalEnd" 
          version="1" 
          uid="B1DF765DE3FA11E6B557B4AC20524153" 
          think="0h" 
          useFilters="true" 
          quiet="true" 
          next="fail" > 

    </Node>


</TestCase>
