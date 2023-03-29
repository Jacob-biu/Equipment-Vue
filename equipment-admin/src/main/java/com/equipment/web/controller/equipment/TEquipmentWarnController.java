package com.equipment.web.controller.equipment;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.equipment.common.core.domain.R;
import com.equipment.common.core.domain.model.LoginUser;
import com.equipment.system.domain.vo.StatisticsVO;
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
import com.equipment.system.domain.TEquipmentWarn;
import com.equipment.system.service.ITEquipmentWarnService;
import com.equipment.common.utils.poi.ExcelUtil;
import com.equipment.common.core.page.TableDataInfo;

/**
 * 报警信息Controller
 *
 * @author equipment
 * @date 2023-02-18
 */
@RestController
@RequestMapping("/system/warn")
public class TEquipmentWarnController extends BaseController
{
    @Autowired
    private ITEquipmentWarnService tEquipmentWarnService;

    /**
     * 查询报警信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:warn:list')")
    @GetMapping("/list")
    public TableDataInfo list(TEquipmentWarn tEquipmentWarn)
    {
        startPage();
        Long userId=this.getUserId();
        String userName=this.getUsername();
        if (userId!=101){
            tEquipmentWarn.setHandleBy(userName);
        }
        List<TEquipmentWarn> list = tEquipmentWarnService.selectTEquipmentWarnList(tEquipmentWarn);
        return getDataTable(list);
    }

    /**
     * 查询报警信息列表
     */
    @GetMapping("/statistics")
    public AjaxResult statistics()
    {
        Long userId=this.getUserId();
        String userName=null;
        if (userId!=101){
            userName=this.getUsername();
        }
        List<StatisticsVO> list = tEquipmentWarnService.statistics(userName);
        return success(list);
    }

    /**
     * 导出报警信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:warn:export')")
    @Log(title = "报警信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TEquipmentWarn tEquipmentWarn)
    {
        List<TEquipmentWarn> list = tEquipmentWarnService.selectTEquipmentWarnList(tEquipmentWarn);
        ExcelUtil<TEquipmentWarn> util = new ExcelUtil<TEquipmentWarn>(TEquipmentWarn.class);
        util.exportExcel(response, list, "报警信息数据");
    }

    /**
     * 获取报警信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:warn:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(tEquipmentWarnService.selectTEquipmentWarnById(id));
    }

    /**
     * 新增报警信息
     */
    @PreAuthorize("@ss.hasPermi('system:warn:add')")
    @Log(title = "报警信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TEquipmentWarn tEquipmentWarn)
    {
        return toAjax(tEquipmentWarnService.insertTEquipmentWarn(tEquipmentWarn));
    }

    /**
     * 修改报警信息
     */
    @PreAuthorize("@ss.hasPermi('system:warn:edit')")
    @Log(title = "报警信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TEquipmentWarn tEquipmentWarn)
    {
        return toAjax(tEquipmentWarnService.updateTEquipmentWarn(tEquipmentWarn));
    }

    /**
     * 删除报警信息
     */
    @PreAuthorize("@ss.hasPermi('system:warn:remove')")
    @Log(title = "报警信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tEquipmentWarnService.deleteTEquipmentWarnByIds(ids));
    }
}
