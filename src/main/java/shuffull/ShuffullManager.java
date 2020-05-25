package shuffull;

import com.google.common.base.Converter;
import java.io.File;
import java.io.FileInputStream;
import javazoom.jl.decoder.Header;
import javazoom.jl.decoder.InputStreamSource;
import javazoom.jl.player.advanced.AdvancedPlayer;

/**
 *
 * @author MC_2018 <mc2018.git@gmail.com>
 */

public class ShuffullManager {
    
    public ShuffullManager() {
        Utilities.verifyFilePathExists(new File("data"));
        
        
    }
    
}
