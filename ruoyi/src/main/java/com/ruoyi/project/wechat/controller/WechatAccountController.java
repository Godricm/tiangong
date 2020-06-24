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
import com.ruoyi.project.wechat.domain.WechatAccount;
import com.ruoyi.project.wechat.service.IWechatAccountService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 微信公众号Controller
 * 
 * @author godrci
 * @date 2020-06-24
 */
@RestController
@RequestMapping("/wechat/account")
public class WechatAccountController extends BaseController
{
    @Autowired
    private IWechatAccountService wechatAccountService;

    /**
     * 查询微信公众号列表
     */
    @PreAuthorize("@ss.hasPermi('wechat:account:list')")
    @GetMapping("/list")
    public TableDataInfo list(WechatAccount wechatAccount)
    {
        startPage();
        List<WechatAccount> list = wechatAccountService.selectWechatAccountList(wechatAccount);
        return getDataTable(list);
    }

    /**
     * 导出微信公众号列表
     */
    @PreAuthorize("@ss.hasPermi('wechat:account:export')")
    @Log(title = "微信公众号", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(WechatAccount wechatAccount)
    {
        List<WechatAccount> list = wechatAccountService.selectWechatAccountList(wechatAccount);
        ExcelUtil<WechatAccount> util = new ExcelUtil<WechatAccount>(WechatAccount.class);
        return util.exportExcel(list, "account");
    }

    /**
     * 获取微信公众号详细信息
     */
    @PreAuthorize("@ss.hasPermi('wechat:account:query')")
    @GetMapping(value = "/{wechatId}")
    public AjaxResult getInfo(@PathVariable("wechatId") Long wechatId)
    {
        return AjaxResult.success(wechatAccountService.selectWechatAccountById(wechatId));
    }

    /**
     * 新增微信公众号
     */
    @PreAuthorize("@ss.hasPermi('wechat:account:add')")
    @Log(title = "微信公众号", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WechatAccount wechatAccount)
    {
        return toAjax(wechatAccountService.insertWechatAccount(wechatAccount));
    }

    /**
     * 修改微信公众号
     */
    @PreAuthorize("@ss.hasPermi('wechat:account:edit')")
    @Log(title = "微信公众号", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WechatAccount wechatAccount)
    {
        return toAjax(wechatAccountService.updateWechatAccount(wechatAccount));
    }

    /**
     * 删除微信公众号
     */
    @PreAuthorize("@ss.hasPermi('wechat:account:remove')")
    @Log(title = "微信公众号", businessType = BusinessType.DELETE)
	@DeleteMapping("/{wechatIds}")
    public AjaxResult remove(@PathVariable Long[] wechatIds)
    {
        return toAjax(wechatAccountService.deleteWechatAccountByIds(wechatIds));
    }
}
