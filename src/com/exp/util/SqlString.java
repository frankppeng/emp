package com.exp.util;


/**
 * ʵ���ܹ���ӡSQL
 * @author SZT
 *
 */
public class SqlString {
	
	public static String valueOf(Object obj) {
        return (obj == null) ? "" : obj.toString();
    }
	//ʵ�ִ�ӡSQL
	public  static  void printSql(String sql,Object[] params){
		StringBuffer  sb=new StringBuffer(sql);
		int fromIndex=0;
		if(params!=null){
			for(int i=0;i<params.length;i++){
				int index =sb.indexOf("?", fromIndex);
				if(index==-1){
					sb.append(" ---> error: value too many   ");
					break;
				}
				if(params[i]  instanceof  String){
					sb.replace(index, index+1, "'"+SqlString.valueOf(params[i])+"'");
				}else if(params[i]  instanceof  Number){
					sb.replace(index, index+1, SqlString.valueOf(params[i]));
				}else if(params[i]  instanceof  Character){
					sb.replace(index, index+1, "'"+SqlString.valueOf(params[i])+"'");
				}else  if(params[i]  instanceof  Boolean){
					sb.replace(index, index+1, "'"+SqlString.valueOf(params[i])+"'");
				}else  if(params[i]  instanceof  Object []){
					sb.replace(index, index+1, "'"+SqlString.valueOf(params[i])+"'");
				}else  if(params[i]  instanceof  java.sql.Date){
					sb.replace(index, index+1, " date '"+SqlString.valueOf(params[i])+"'");
				}else if(params[i]  instanceof  java.util.Date){
					sb.replace(index, index+1, "'java.util.Date'");
				}
				
				fromIndex=index+1;
				
			}
		}
		System.out.println(sb.toString());
		
	}
	public static void main(String[] args) {
		String sql="insert into  mydate values(?,?,?,?)";
		SqlString.printSql(sql, new Object[]{"adfa",null,null,new java.sql.Date(System.currentTimeMillis())});
	}
}
