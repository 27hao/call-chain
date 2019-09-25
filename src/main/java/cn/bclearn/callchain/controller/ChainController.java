package cn.bclearn.callchain.controller;

import cn.bclearn.callchain.db.entity.MethodNode;
import cn.bclearn.callchain.db.service.MethodNodeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
public class ChainController {

    @Autowired
    private MethodNodeService methodNodeService;

    private Logger logger = LoggerFactory.getLogger(ChainController.class);

    /**
     * 返回HTML网页形式的分析结果
     * @return
     */
    @RequestMapping(value = "/callChain",method = RequestMethod.GET)
    public List<MethodNode> getViewAll(){
        List<MethodNode> nodes = methodNodeService.findAll();
        if (nodes!=null) {
            nodes = nodes.stream().filter(MethodNode::isFirst).collect(Collectors.toList());
        }
        return nodes;
    }

    @RequestMapping(value = "/callChain/all",method = RequestMethod.GET)
    public List<MethodNode> getView(){
        return methodNodeService.findAll();
    }

    @RequestMapping("/callChain/{methodId}")
    public MethodNode getAll(@PathVariable Long methodId){
        return methodNodeService.findAllById(methodId);
    }


}
