#OBS: THIS CODE WON'T WORK ON JUPYTER NOTEBOOK, JUST ON PYCHARM IDE

from memory_profiler import profile

@profile
def coumpound_interest(tot, years, actual):
    if actual == years:
        return tot
    else:
        tot += tot * 0.03
        print(tot)
        return tot + coumpound_interest(tot, years, actual + 1)

if __name__ == '__main__':
    coumpound_interest(10000, 8, 0)