# spring cloud 踩坑记
无法启动，报错信息
```
failed to introspect Class[org.springframework.cloud.context.properties.ConfigurationPropertiesBea]
```
原因及解决
```
原因：使用的spring boot版本号为2.5.3，springcloud的版本是Hoxton.SR8，官网上看这个版本的适合spring boot版本为2.2.x和2.3.x
解决：springboot版本改为2.3.12.RELEASE
```

