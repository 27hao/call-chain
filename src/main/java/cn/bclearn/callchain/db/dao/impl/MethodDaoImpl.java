package cn.bclearn.callchain.db.dao.impl;

import cn.bclearn.callchain.db.dao.MethodNodeDao;
import cn.bclearn.callchain.db.entity.MethodNode;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class MethodDaoImpl implements MethodNodeDao {
    private final List<MethodNode> methodNodeList = new ArrayList<>();

    @Override
    public MethodNode findAllById(Long id) {
        List<MethodNode> nodes = methodNodeList.stream().filter(m -> m.getId().equals(id)).collect(Collectors.toList());
        return nodes.size() != 0 ? nodes.get(0) : null;
    }

    @Override
    public boolean save(MethodNode methodNode) {
        methodNode.setId((long) methodNodeList.size());
        return methodNodeList.add(methodNode);
    }

    @Override
    public List<MethodNode> findAll() {
        return methodNodeList;
    }

    @Override
    public List<MethodNode> findAllByMethodId(String methonId) {
        return methodNodeList.stream().filter(m -> m.getMethodId().equals(methonId)).collect(Collectors.toList());
    }
}
