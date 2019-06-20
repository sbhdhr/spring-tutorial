module demo.spring.annotations {
	requires java.sql;
	requires spring.context;
	requires spring.beans;
	requires spring.core;
	opens demo.spring.annotations.pkg;
}