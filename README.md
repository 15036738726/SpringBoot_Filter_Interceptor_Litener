# SpringBoot_Filter_Interceptor_Litener
过滤器Filter,拦截器Interceptor,监听器Litener操作对比

https://blog.csdn.net/weixin_44830949/article/details/127493342
区别对比:
1、过滤器和拦截器触发时机不一样，过滤器是在请求进入容器后，但请求进入servlet之前进行预处理的。请求结束返回也是，是在servlet处理完后，返回给前端之前。

2、拦截器可以获取IOC容器中的各个bean，而过滤器就不行，因为拦截器是spring提供并管理的，spring的功能可以被拦截器使用，在拦截器里注入一个service，
可以调用业务逻辑。而过滤器是JavaEE标准，只需依赖servlet api ，不需要依赖spring。

3、过滤器的实现基于回调函数。而拦截器（代理模式）的实现基于反射

4、Filter是依赖于Servlet容器，属于Servlet规范的一部分，而拦截器则是独立存在的，可以在任何情况下使用。

5、Filter的执行由Servlet容器回调完成，而拦截器通常通过动态代理（反射）的方式来执行。

6、Filter的生命周期由Servlet容器管理，而拦截器则可以通过IoC容器来管理，因此可以通过注入等方式来获取其他Bean的实例，因此使用会更方便。




SpringBoot 中过滤器、拦截器、监听器的基本使用
https://blog.csdn.net/zqf787351070/article/details/126908980

过滤器配置:
创建类->实现Filter接口->覆写doFilter方法 -> 
过滤器注册:声明一个配置类,定义返回值类型为FilterRegistrationBean的方法
private static final String[] URLS = new String[]{"/test/filter", "/test/all"};
@Bean("myFilter1")
public FilterRegistrationBean<Filter> myFilter1() {
	FilterRegistrationBean<Filter> registrationBean = new FilterRegistrationBean<>(new MyFilter1());
	// 配置要应用过滤器的路径，若存在多个则传入 String[]
	registrationBean.addUrlPatterns(URLS);
	// 设置执行顺序，数值越小，越先执行，服务器返回客户端时则相反
	registrationBean.setOrder(1);
	return registrationBean;
}


过滤器测试:
http://localhost:9090/test/filter

===过滤器1前处理===
===过滤器2前处理===
===执行 controller===
===调用 service 进行业务处理===
===执行 return===
===过滤器2后处理===
===过滤器1后处理===



拦截器配置:
创建类->实现HandlerInterceptor接口->覆写preHandle/postHandle方法 -> 
过滤器注册:声明一个配置类,实现WebMvcConfigurer接口,覆写addInterceptors方法,通过InterceptorRegistry对象添加拦截配置
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 拦截路径
        String[] urls = new String[]{"/test/interceptor", "/test/all"};
        // 配置自定义的拦截器，配置路径以及顺序
        registry.addInterceptor(new MyInterceptor1()).addPathPatterns(urls).order(1);
        registry.addInterceptor(new MyInterceptor2()).addPathPatterns(urls).order(2);
    }
}


拦截器测试:
http://localhost:9090/test/interceptor
===拦截器1前处理===
===拦截器2前处理===
===执行 controller===
===调用 service 进行业务处理===
===执行 return===
===拦截器2后处理===
===拦截器1后处理===



同时测试，验证过滤器和拦截器的执行顺序
http://localhost:9090/test/all
===过滤器1前处理===
===过滤器2前处理===
===拦截器1前处理===
===拦截器2前处理===
===执行 controller===
===调用 service 进行业务处理===
===执行 return===
===拦截器2后处理===
===拦截器1后处理===
===过滤器2后处理===
===过滤器1后处理===



监听器 Litener



