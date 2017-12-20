package com.hibernateUtil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {

    // SessionFactoryʵ�����Ự������
    private static SessionFactory sessionFactory = null;
    
    /**
     * ��̬��ʼ�� Hibernate 
     */
    static {
        // 1 ���� StandardServiceRegistry ʵ������׼ע�����
        // 1.1 ���� StandardServiceRegistryBuilder ʵ������׼ע�������������
        // 1.2 �� hibernate.cfg.xml �����ļ��ж�ȡ������Ϣ
        // 1.3 ���� StandardServiceRegistryʵ������׼ע�����
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();

        try {
            // 2 ���� SessionFactory ʵ�����Ự������
            // 2.1 ���ݱ�׼ע����񴴽�һ��  MetadataSources ʵ����Ԫ������Դ����
            // 2.2 ����Ԫ����
            // 2.3 ����Ӧ��һ��Ψһ�� SessionFactory ʵ�����Ự������
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception e) {
            // 2.4 ����ʧ���ֶ��ͷ� StandardServiceRegistry ʵ��
            StandardServiceRegistryBuilder.destroy(registry);
            e.printStackTrace();
        }
    }

    /**
     * ��һ�� Session �Ự
     * @return Session
     */
    public static Session openSession() {
        return sessionFactory.openSession();
    }
}
