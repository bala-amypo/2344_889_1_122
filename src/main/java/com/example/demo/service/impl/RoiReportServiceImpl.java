@Service
public class RoiReportServiceImpl implements RoiService {

    private final RoiReportRepository repository;

    public RoiReportServiceImpl(RoiReportRepository repository) {
        this.repository = repository;
    }
}
