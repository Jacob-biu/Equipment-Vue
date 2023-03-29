package com.equipment.web.controller.equipment;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
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
import com.equipment.common.annotation.Log;
import com.equipment.common.core.controller.BaseController;
import com.equipment.common.core.domain.AjaxResult;
import com.equipment.common.enums.BusinessType;
import com.equipment.system.domain.TEquiment;
import com.equipment.system.service.ITEquimentService;
import com.equipment.common.utils.poi.ExcelUtil;
import com.equipment.common.core.page.TableDataInfo;

/**
 * 设备Controller
 *
 * @author equipment
 * @date 2023-02-18
 */
@RestController
@RequestMapping("/system/equiment")
public class TEquimentController extends BaseController
{
    @Autowired
    private ITEquimentService tEquimentService;

    /**
     * 查询设备列表
     */
    @PreAuthorize("@ss.hasPermi('system:equiment:list')")
    @GetMapping("/list")
    public TableDataInfo list(TEquiment tEquiment)
    {
        startPage();
        List<TEquiment> list = tEquimentService.selectTEquimentList(tEquiment);
        return getDataTable(list);
    }

    /**
     * 导出设备列表
     */
    @PreAuthorize("@ss.hasPermi('system:equiment:export')")
    @Log(title = "设备", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TEquiment tEquiment)
    {
        List<TEquiment> list = tEquimentService.selectTEquimentList(tEquiment);
        ExcelUtil<TEquiment> util = new ExcelUtil<TEquiment>(TEquiment.class);
        util.exportExcel(response, list, "设备数据");
    }

    /**
     * 获取设备详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:equiment:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(tEquimentService.selectTEquimentById(id));
    }

    /**
     * 新增设备
     */
    @PreAuthorize("@ss.hasPermi('system:equiment:add')")
    @Log(title = "设备", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TEquiment tEquiment)
    {
        return toAjax(tEquimentService.insertTEquiment(tEquiment));
    }

    /**
     * 修改设备
     */
    @PreAuthorize("@ss.hasPermi('system:equiment:edit')")
    @Log(title = "设备", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TEquiment tEquiment)
    {
        return toAjax(tEquimentService.updateTEquiment(tEquiment));
    }

    /**
     * 删除设备
     */
    @PreAuthorize("@ss.hasPermi('system:equiment:remove')")
    @Log(title = "设备", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tEquimentService.deleteTEquimentByIds(ids));
    }
}
