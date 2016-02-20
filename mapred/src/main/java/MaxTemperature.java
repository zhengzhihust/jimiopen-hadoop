import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;

import java.io.IOException;

/**
 * Created by yuanlang on 2/20/16.
 */
public class MaxTemperature {

    private static JobConf conf;

    private JobConf getJobConfInstance(String inputPath, String outputPath){
        if (conf == null) {
            synchronized (this){
                if (conf == null){
                    initJobConf(conf, inputPath, outputPath);
                }
            }
        }
        return conf;
    }

    private void initJobConf(JobConf conf, String inputPath, String outputPath){
        conf = new JobConf(MaxTemperature.class);
        conf.setJobName("Max temperature");
        FileInputFormat.addInputPath(conf, new Path(inputPath));
        FileOutputFormat.setOutputPath(conf, new Path(outputPath));
        conf.setMapperClass(MaxTemperatureMapper.class);
        conf.setReducerClass(MaxTemperatureReducer.class);
        conf.setOutputKeyClass(Text.class);
        conf.setOutputValueClass(IntWritable.class);
    }

    public static void main(String[] args) throws IOException {
        JobClient.runJob(new MaxTemperature().getJobConfInstance(args[0], args[1]));
    }
}
