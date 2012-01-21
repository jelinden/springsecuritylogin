A simple project start using spring-data, mongodb and spring-security
========

You need to have mongodb setup (expects one instance with default port 27017).
See fi.springsecuritylogin.config.MongoTemplateConfig
Set up mongodb on your computer (< href="http://www.mongodb.org/downloads">Downloads</a>)
 - windows (http://www.mongodb.org/display/DOCS/Quickstart+Windows)
 - unix (http://www.mongodb.org/display/DOCS/Quickstart+Unix)
 - osx (http://www.mongodb.org/display/DOCS/Quickstart+OS+X)

There is no page to handle user roles yet. For modifying an existing user to ROLE_ADMIN, use:
db.usercollection.update({username: "USERNAME"},{"$set":{authorities:{ "role" : "ROLE_ADMIN", "_class" : "org.springframework.security.core.authority.SimpleGrantedAuthority"}}});

If you nees roles with IP restrictions, use:

<http use-expressions="true">
    <intercept-url pattern="/admin*"
        access="hasRole('admin') and hasIpAddress('192.168.1.0/24')"/>
    ...
</http>

See security-context.xml and http://static.springsource.org/spring-security/site/docs/3.1.x/reference/el-access.html#el-access-web
for more.
========


