package br.com.testes.mybatis.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import br.com.testes.mybatis.dao.ClienteMapper;
import br.com.testes.mybatis.model.Cliente;
import br.com.testes.mybatis.model.ClienteExample;

public class Principal {
	public static void main(String[] args) {
		String resource = "br/com/testes/mybatis/controller/mybatis-config.xml";
		InputStream inputStream;
		try {
			
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			SqlSessionFactory sqlSessionFactory = builder.build(inputStream);
			sqlSessionFactory.getConfiguration().addMapper(ClienteMapper.class);
			SqlSession sqlSession = sqlSessionFactory.openSession();
			ClienteMapper mapper = sqlSession.getMapper(ClienteMapper.class);
			List<Cliente> selectByExample = mapper.selectByExample(new ClienteExample());
			for (Cliente cliente : selectByExample) {
				System.out.println(cliente.getNome());
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
