package com.ruoyi.project.wechat.controller;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.project.wechat.domain.AccountWechat;
import com.ruoyi.project.wechat.service.IAccountWechatService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 微信公众号Controller
 * 
 * @author ruoyi
 * @date 2020-06-21
 */
@RestController
@RequestMapping("/wechat/account")
public class AccountWechatController extends BaseController
{
    @Autowired
    private IAccountWechatService accountWechatService;

    /**
     * 查询微信公众号列表
     */
    @PreAuthorize("@ss.hasPermi('wechat:wechat:list')")
    @GetMapping("/list")
    public TableDataInfo list(AccountWechat accountWechat)
    {
        startPage();
        List<AccountWechat> list = accountWechatService.selectAccountWechatList(accountWechat);
        return getDataTable(list);
    }

    /**
     * 导出微信公众号列表
     */
    @PreAuthorize("@ss.hasPermi('wechat:wechat:export')")
    @Log(title = "微信公众号", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(AccountWechat accountWechat)
    {
        List<AccountWechat> list = accountWechatService.selectAccountWechatList(accountWechat);
        ExcelUtil<AccountWechat> util = new ExcelUtil<AccountWechat>(AccountWechat.class);
        return util.exportExcel(list, "wechat");
    }

    /**
     * 获取微信公众号详细信息
     */
    @PreAuthorize("@ss.hasPermi('wechat:wechat:query')")
    @GetMapping(value = "/{wechatId}")
    public AjaxResult getInfo(@PathVariable("wechatId") Long wechatId)
    {
        return AjaxResult.success(accountWechatService.selectAccountWechatById(wechatId));
    }

    /**
     * 新增微信公众号
     */
    @PreAuthorize("@ss.hasPermi('wechat:wechat:add')")
    @Log(title = "微信公众号", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AccountWechat accountWechat)
    {
        return toAjax(accountWechatService.insertAccountWechat(accountWechat));
    }

    /**
     * 修改微信公众号
     */
    @PreAuthorize("@ss.hasPermi('wechat:wechat:edit')")
    @Log(title = "微信公众号", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AccountWechat accountWechat)
    {
        return toAjax(accountWechatService.updateAccountWechat(accountWechat));
    }

    /**
     * 删除微信公众号
     */
    @PreAuthorize("@ss.hasPermi('wechat:wechat:remove')")
    @Log(title = "微信公众号", businessType = BusinessType.DELETE)
	@DeleteMapping("/{wechatIds}")
    public AjaxResult remove(@PathVariable Long[] wechatIds)
    {
        return toAjax(accountWechatService.deleteAccountWechatByIds(wechatIds));
    }
}
