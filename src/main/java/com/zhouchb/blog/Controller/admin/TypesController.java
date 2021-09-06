package com.zhouchb.blog.Controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.org.apache.xpath.internal.operations.Mod;
import com.zhouchb.blog.bean.Type;
import com.zhouchb.blog.service.TypesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.naming.Binding;
import javax.validation.Valid;
import java.util.List;

/**
 * @Author Zhouchb
 * @Create 2021-09-2021/9/5 :9:49
 * @Description
 */
@Slf4j
@Controller
@RequestMapping("/admin")
public class TypesController {

    @Autowired
    private TypesService typesService;

    @GetMapping("/types")
    public String types(@RequestParam(value = "pn",defaultValue =" 1")Integer pn, Model model){
        //传入页码，和一页显示多少
        PageHelper.startPage(pn,6);
        List<Type> types = typesService.listType();
        //连续显示多少页
        PageInfo<Type> typePageInfo = new PageInfo<>(types, 5);
        model.addAttribute("pageinfo",typePageInfo);
        return "admin/types";
    }
    @GetMapping("/types/type_release")
    public String typeRelease(Model model){
        model.addAttribute("type",new Type());
        return "admin/type_release";
    }
//新增
    @PostMapping("/types")
    public String typesPost(@Valid Type type, BindingResult binding, RedirectAttributes redirectAttributes){
        Type typeByName = typesService.getTypeByName(type.getName());
        if (typeByName != null){
            binding.rejectValue("name","Error","彬哥类型名已经存在了");
        }
        if (binding.hasErrors()){
          return "admin/type_release";
      }
        int i = typesService.saveType(type);
        if (i>0){
            redirectAttributes.addFlashAttribute("TypeMessage", "恭喜恭喜！类型添加成功！");
        }else {
            redirectAttributes.addFlashAttribute("TypeMessage", "哎呀呀！添加失败失败了呀！");
        }
        return "redirect:/admin/types";
    }

    @PostMapping("/types/{id}")
    public String typesUpdatePost(@Valid Type type, BindingResult binding,@PathVariable Long id, RedirectAttributes redirectAttributes){
        Type typeByName = typesService.getTypeByName(type.getName());

        if (typeByName != null){
            binding.rejectValue("name","Error","彬哥类型名已经存在了");
        }
        //判定输入name是否为空，出现error
        if (binding.hasErrors()){
            return "admin/type_release";
        }
        int i = typesService.updateType(id,type);
        if (i>0){
            redirectAttributes.addFlashAttribute("TypeMessage", "恭喜恭喜！类型更新成功！");
        }else {
            redirectAttributes.addFlashAttribute("TypeMessage", "哎呀呀！更新失败失败了呀！");
        }
        return "redirect:/admin/types";
    }
    //编辑
   @GetMapping("/types/{id}/input")
    public String typeEdit(@PathVariable("id") Long id,Model model){
        model.addAttribute("type",typesService.getType(id));
        return "admin/type_release";
   }
   @ResponseBody
   @GetMapping("/types/del/{id}")
    public String ajaxTest(@PathVariable("id")Long id){
        log.info("我执行了"+id);
      typesService.deleteType(id);
       return "删除成功";
   }

}
