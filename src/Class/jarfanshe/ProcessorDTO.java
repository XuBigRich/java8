package Class.jarfanshe;


import org.apache.thrift.TProcessor;

public class ProcessorDTO {
    private String processorName;
    private TProcessor processor;

    public String getProcessorName() {
        return processorName;
    }

    public void setProcessorName(String processorName) {
        this.processorName = processorName;
    }

    public TProcessor getProcessor() {
        return processor;
    }

    public void setProcessor(TProcessor processor) {
        this.processor = processor;
    }
}
