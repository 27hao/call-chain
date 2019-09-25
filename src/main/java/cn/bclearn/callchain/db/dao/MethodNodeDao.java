package cn.bclearn.callchain.db.dao;

import cn.bclearn.callchain.db.entity.MethodNode;

import java.util.List;

public interface MethodNodeDao {

    MethodNode findAllById(Long id);

    boolean save(MethodNode methodNode);

    List<MethodNode> findAll();

    List<MethodNode> findAllByMethodId(String methonId);
}
