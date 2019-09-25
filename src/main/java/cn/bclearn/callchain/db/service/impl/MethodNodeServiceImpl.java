package cn.bclearn.callchain.db.service.impl;

import cn.bclearn.callchain.db.dao.MethodNodeDao;
import cn.bclearn.callchain.db.entity.MethodNode;
import cn.bclearn.callchain.db.service.util.ServiceUtil;
import cn.bclearn.callchain.db.service.MethodNodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MethodNodeServiceImpl implements MethodNodeService {
    @Autowired
    private MethodNodeDao methodNodeDao;

    @Override
    public boolean saveNotRedo(MethodNode methodNode) {
        //根据方法签名查找是否已存在该方法
        List<MethodNode> methodList = methodNodeDao.findAllByMethodId(methodNode.getMethodId());
        //不存在直接保存,若存在调用链不相同也保存
        if (methodList == null || methodList.size()==0|| !ServiceUtil.analyzeList(methodNode, methodList)) {
            return methodNodeDao.save(methodNode);
        }
        return false;
    }

    @Override
    public List<MethodNode> findAll() {
        return methodNodeDao.findAll();
    }

    @Override
    public MethodNode findAllById(Long id) {
        return methodNodeDao.findAllById(id);
    }

}
