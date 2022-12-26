package grid.startingTemplates;

import java.util.HashMap;
import java.util.Map;

public enum TemplatesEnum {
    template1(1,new StartingTemplate1()),
    template2(2,new StartingTemplate2());


    public final StartingTemplate template;
    private final int index;
    private static final Map<Integer, TemplatesEnum> map=new HashMap<>();
    TemplatesEnum(int index,StartingTemplate template){
        this.template=template;
        this.index=index;
    }
    static {
        for (TemplatesEnum template: TemplatesEnum.values()){
            map.put(template.index,template);
        }
    }
    public static StartingTemplate getTemplate(int index){
        return map.get(index).template;
    }


}
