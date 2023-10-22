import cpu.CPU;
import io.InputOutput;
import memory.cache.AddressConverter;
import memory.cache.Cache;
import memory.ramslicer.SliceABlock;
import memory.ram.RAM;

public class Main {

    public static void main(String[] args) {

        InputOutput io = new InputOutput(System.in, System.out);

        RAM ram = new RAM(22);

        int cacheSize = (int) (4 * Math.pow(2, 10));
        AddressConverter addressConverter = new AddressConverter(cacheSize, 16);
        SliceABlock ramSlicer = new SliceABlock(ram, addressConverter);
        Cache cache = new Cache(addressConverter, io, ramSlicer);

        CPU cpu = new CPU(cache, io);

        /*
        io.output("------------------------------\n");
        io.output("Programa 1\n");
        io.output("------------------------------");
        int startAddress = 0;
        ram.write(startAddress, 118);
        ram.write(startAddress + 1, 130);
        cpu.run(startAddress);

        io.output("\n------------------------------\n");
        io.output("Programa 2\n");
        io.output("------------------------------");
        cache.write(startAddress, 4155);
        cache.write(startAddress + 1, 4165);
        cpu.run(startAddress);
         */

        cache.read(10);
        cache.read(20);
        cache.read(15);
        cache.read(30);
        cache.read(65);
        cache.read(35);
        cache.read(45);
        cache.read(25);
        cache.read(60);
        cache.read(50);
    }
}
