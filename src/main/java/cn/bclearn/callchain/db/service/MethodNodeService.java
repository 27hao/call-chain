package cn.bclearn.callchain.db.service;

import cn.bclearn.callchain.db.entity.MethodNode;

import java.util.List;

public interface MethodNodeService {

    boolean saveNotRedo(MethodNode node);

    List<MethodNode> findAll();

    MethodNode findAllById(Long id);
}
