package grid.startingTemplates;

import java.util.HashMap;
import java.util.Map;

public enum TemplatesEnum {
    template1(1,new Template1()),
    template2(2,new Template2());


    public final Template template;
    private final int index;
    private static final Map<Integer, TemplatesEnum> map=new HashMap<>();
    TemplatesEnum(int index, Template template){
        this.template=template;
        this.index=index;
    }
    static {
        for (TemplatesEnum template: TemplatesEnum.values()){
            map.put(template.index,template);
        }
    }
    public static Template getTemplate(int index){
        return map.get(index).template;
    }


}
