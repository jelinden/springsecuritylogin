A simple project start using spring-data, mongodb and spring-security
========

You need to have mongodb setup (expects one instance with default port 27017).
Set up mongodb on your computer (<a href="http://www.mongodb.org/downloads">Downloads</a>)

 - windows (http://www.mongodb.org/display/DOCS/Quickstart+Windows)

 - unix (http://www.mongodb.org/display/DOCS/Quickstart+Unix)

 - osx (http://www.mongodb.org/display/DOCS/Quickstart+OS+X)

See fi.springsecuritylogin.config.MongoTemplateConfig

There is no page to handle user roles yet. For modifying an existing user to ROLE_ADMIN, use:

<pre lang="javascript"><code>
db.usercollection.update({username: "USERNAME"},{"$set":{
    authorities:{ 
    "role" : "ROLE_ADMIN", 
    "_class" : "org.springframework.security.core.authority.SimpleGrantedAuthority"}
    }});
</code></pre>

If you need roles with IP restrictions, use:

```xml
<http use-expressions="true">
    <intercept-url pattern="/admin*"
        access="hasRole('admin') and hasIpAddress('192.168.1.0/24')"/>
    ...
</http>
```

See security-context.xml and http://static.springsource.org/spring-security/site/docs/3.1.x/reference/el-access.html#el-access-web for more.



SSL
========
You need to add it your self.


jetty session management
========
See: <a href="https://github.com/yyuu/jetty-nosql-memcached">jetty-nosql-memcached</a>


